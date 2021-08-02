using System;
using System.CodeDom;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Linq;
/*
 * Vinny DiMaggio
 * Assignment 6
 * Linked list from scratch implementation
 */

namespace GenericLinkedList
{
    class GenericNode<T>
    {
        public T value;
        public GenericNode<T> next = null;
    }


    class LinkedListCollection<T>
    {
        private GenericNode<T> _parent = null;
        public int Count { get; private set; } = 0;


        public LinkedListCollection(T val)
        {
            _parent = new GenericNode<T>() {value = val};
        }

        public void Add(T val)
        {
            if (_parent == null)
                _parent.value = val;
            else
            {
                GenericNode<T> currentNode = _parent;
                while(currentNode.next != null)
                {
                    currentNode = currentNode.next;
                }
                currentNode.next = new GenericNode<T>() {value = val};
            }

            Count++;
        }

        public void Insert(int idx, T item)
        {
            if (idx >= Count)
            {
                Add(item); //put item at end if invalid index entered
                return;
            }

            //item is new parent, update parent
            if (idx == 0)
            {
                _parent = new GenericNode<T>(){value = item, next = _parent.next};
                return;
            }

            //Navigate to one less than the required node and insert after it
            GenericNode<T> currentNode = _parent;
            for (int currentIndex = 0; currentIndex < idx-1; currentIndex++)
            {
                currentNode = currentNode.next;
            }
            GenericNode<T> newNode = new GenericNode<T> {value = item, next = currentNode.next};
            currentNode.next = newNode;
        }

        public T this[int idx] 
        {
            get
            {
                GenericNode<T> currentNode = _parent;
                int currentIndex = 0;

                //loop to end of list
                while (currentNode != null)
                {
                    //given index found
                    if (idx == currentIndex)
                        return currentNode.value;
                    currentIndex++;
                    currentNode = currentNode.next;
                }

                //thrown when index out of range is given
                throw new IndexOutOfRangeException();
            }
        }

        public int IndexOf(T item)
        {
            GenericNode<T> currentNode = _parent;
            int currentIndex = 0;

            //loop to end of list
            while (currentNode != null)
            {
                //given item is found
                if (currentNode.value.Equals(item))
                    return currentIndex;
                currentIndex++;
                currentNode = currentNode.next;
            }

            //-1 given if item is not in list
            return -1;
        }


        public void RemoveAt(int idx)
        {
            //Node to be removed is parent
            if (idx == 0)
            {
                GenericNode<T> returnNode = _parent;
                _parent = _parent.next;
                Count--;
            }

            GenericNode<T> currentNode = _parent.next;
            GenericNode<T> previousNode = _parent;
            int currentIndex = 1;
            
            //loop to end of list
            while (currentNode != null)
            {
                //index to be removed is found
                if (idx == currentIndex)
                {
                    previousNode.next = currentNode.next;
                    Count--;
                    return;
                }

                currentIndex++;
                currentNode = currentNode.next;
                previousNode = previousNode.next;
            }
        }

        public void Remove(T item)
        {
            //Node to be removed is parent
            if (_parent.value.Equals(item))
            {
                GenericNode<T> returnNode = _parent;
                _parent = _parent.next;
                Count--;
            }

            GenericNode<T> currentNode = _parent.next;
            GenericNode<T> previousNode = _parent;

            //loop to end of list
            while (currentNode != null)
            {
                //item to be removed found
                if (currentNode.value.Equals(item))
                {
                    previousNode.next = currentNode.next;
                    Count--;
                    return;
                }
                currentNode = currentNode.next;
                previousNode = previousNode.next;
            }
        }

        public void Clear()
        {
            _parent = null;
            Count = 0;
        }

        public bool Contains(T item)
        {
            GenericNode<T> currentNode = _parent;
            //loop through list
            while (currentNode != null)
            {
                //item found
                if (currentNode.value.Equals(item))
                    return true;

                currentNode = currentNode.next;
            }

            return false;
        }



    }
}