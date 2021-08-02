using System;
using System.Collections.Generic;
using System.IO;
using System.Security.Cryptography;


/*
Vinny DiMaggio
Assignment 11
This program determines if there are any duplicate files 
in a directory and reports the total bytes the duplicates 
are taking up.
*/

namespace DuplicateFileDetector
{

    class Program
    {
        static void Main(string[] args)
        {

            //Get directory to search for duplicates
            Console.Write("Enter a Directory to Search: ");
            String dirString = Console.ReadLine();
            DirectoryInfo dir = new DirectoryInfo(dirString);


            long bytesWasted = ReportDuplicateFiles(dir);

            //Report total bytes wasted
            Console.WriteLine("Duplicate files are wasting {0} bytes.", bytesWasted);


        }

        public static long ReportDuplicateFiles(DirectoryInfo directory)
        {
            Dictionary<String, String> fileDictionary = new Dictionary<string, string>();
            long bytesWasted = 0;

            using (SHA1 sha1Hash = SHA1.Create())
            {

                foreach (FileInfo file in directory.GetFiles())
                {
                    FileStream stream = File.OpenRead(file.FullName);
                    //create hash for file
                    byte[] hash = sha1Hash.ComputeHash(stream);
                    string hashString = BitConverter.ToString(hash).Replace("-", "").ToLower();

                    try
                    {
                        fileDictionary.Add(hashString, file.FullName);
                    }
                    catch (Exception e)
                    {
                        //if file has same key (hash) as another file report the duplicate and add the bytes to the total
                        Console.WriteLine("The file: {0} and the file: {1} are duplicates", file.FullName, fileDictionary[hashString]);
                        bytesWasted += file.Length;
                    }
                }
            }

            return bytesWasted;

        }

    }


}
