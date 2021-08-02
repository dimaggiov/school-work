# Vinny DiMaggio
# Assignment 3
# This program demonstrates operator overloading by overloading the + - * and == for matrices

import random


class Matrix:

    def __init__(self, m, n):
        # create an (m by n) dummy 2D matrix with all zeros
        self._mat = [[0] * n for y in range(m)]

    def __add__(self, other):
        # Make sure matrices are the same size
        if len(self._mat) != len(other._mat) or len(self._mat[0]) != len(other._mat[0]):
            raise Exception('Incompatible matrices for addition')

        new_matrix = Matrix(len(self._mat), len(self._mat[0]))

        for i in range(len(self._mat)):
            for j in range(len(self._mat[0])):
                new_matrix._mat[i][j] = self._mat[i][j] + other._mat[i][j]

        return new_matrix

    def __sub__(self, other):
        # Make sure matrices are the same size
        if len(self._mat) != len(other._mat) or len(self._mat[0]) != len(other._mat[0]):
            raise Exception('Incompatible matrices for subtraction')

        new_matrix = Matrix(len(self._mat), len(self._mat[0]))

        for i in range(len(self._mat)):
            for j in range(len(self._mat[0])):
                new_matrix._mat[i][j] = self._mat[i][j] - other._mat[i][j]

        return new_matrix

    def __mul__(self, other):
        # Make sure matrices are compatible (rows of the first equals columns of the second)
        if len(self._mat[0]) != len(other._mat):
            raise Exception('Incompatible matrices for multiplication')

        new_matrix = Matrix(len(self._mat), len(other._mat[0]))

        for i in range(len(self._mat)):
            for j in range(len(other._mat[0])):
                for k in range(len(other._mat)):
                    new_matrix._mat[i][j] += self._mat[i][k] * other._mat[k][j]

        return new_matrix

    def __eq__(self, other):
        # Make sure matrices are the same size
        if len(self._mat) != len(other._mat) or len(self._mat[0]) != len(other._mat[0]):
            return False

        for i in range(len(self._mat)):
            for j in range(len(self._mat[0])):
                if self._mat[i][j] != other._mat[i][j]:
                    return False

        return True

    # Populate matrix with random elements for testing
    def populate(self):
        for i in range(len(self._mat)):
            for j in range(len(self._mat[0])):
                self._mat[i][j] = random.randint(1, 10)


# Tester program

# Create and populate 3 arrays with random values
A = Matrix(3, 4)
A.populate()
B = Matrix(3, 4)
B.populate()
C = Matrix(4, 2)
C.populate()

# Print out the matrices
print('A = ', A._mat)
print('B = ', B._mat)
print('C = ', C._mat)

# perform addition, subtraction, multiplication and test for equality and print results
added_matrix = A + B
print('A + B = ', added_matrix._mat)
subtracted_matrix = A - B
print('A - B = ', subtracted_matrix._mat)
multiplied_matrix = A * C
print('A * B = ', multiplied_matrix._mat)
print('A == B? ', A == B)

# Sample output
# A =  [[3, 2, 2, 2], [3, 7, 7, 3], [9, 8, 10, 5]]
# B =  [[5, 10, 6, 3], [3, 7, 2, 1], [3, 4, 7, 3]]
# C =  [[9, 6], [2, 1], [9, 6], [3, 10]]
# A + B =  [[8, 12, 8, 5], [6, 14, 9, 4], [12, 12, 17, 8]]
# A - B =  [[-2, -8, -4, -1], [0, 0, 5, 2], [6, 4, 3, 2]]
# A * B =  [[55, 52], [113, 97], [202, 172]]
# A == B?  False
