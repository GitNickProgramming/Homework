## Chapter 1

### Suggested Exercise:
1. **Consider the combinations problem:**
    - Given given integers **n > 0** and **k ≥ 0**, with **n >= k**, list all the ways to choose k things  out of n (*use n distinct symbols*). 
    - Assume that order doesn’t matter, in the sense that ab and ba are considered the same, so it’s easiest to use words that have the letters in alphabetical order, like abc instead of acb or any of the other permutations of those three symbols.
    - For Example
        - With **n = 4** and **k = 2**, the desired list is `ab, ac, ad, bc, bd, cd`
    - Design nodes and decisions to build a tree of possiblities for the intances with **n = 5** and **k= 3**.

### Exercise 1 [10 points] - (Traveling Salesperson problem by Brute Force):
1. Suppose we have a directed graph (like below) with *n* vertices labeled 1 through *n*, implemented using an *n* matric where row *j*, column *k* contains the weight of the edge going from vertex *j* to vertex *k*, or a dash if there is no edge from *j* to *k*.
    - The traveling Salesperson Problem (TSP) is as follows:
        - given a weight matrix as input, determine the cycle - a path that starts at vertex 1, hits all the vertices exactly once, and ends up back at vertex 1 - that has smallest total weight of its edge. Note that the minimum weight cycle might be infinity.
    - Figure out how to use the brute force technique to solve an instance of this problem, and demonstrate your algorithm on the matrix below. be sure to think about pruning, and what information should be kept in each node.
    - Submit your work (just show me the possibilities tree for the instance, along with statement of the answer, which is the best cycle) through Canvas.
    - Directed Graph:
![](C:\Users\Nicholas\Pictures\Saved Pictures\directed_graph.png)


### Exercise 2 [4 points] - (Sums to n Problem by Brute Force):
1. Consider the "sums to *n* problem:"
    - Given a **positive** integer *n*, list all the different ways to get a collection of positive integers adding up to *n*. Assume that we don't care about order, so 1 + 2 and 2 + 1 are the same possibility.
    - For *n* = 3, the possibilites are:
        - 1 + 1 + 1
        - 1 + 2
        - 3
    - Your job on this porject is to create a Java class that will take *n* as input and produce a list of all the possiblities (with each item in the list on its own row, with the integers in it in nondecreasing orer left to right).
    - Name the class **SumsToN**. Submite your work through Canvas - I need the source code for all the classes in oyur application (probably just one).
    - Note that I want to be able to take the source files(s) you send me, put them in a folder, go into that folder and at the command line type `javac SumsToN.java` and then type `java SumsToN` and have your application ask, at the command prompt, for the value of *n* and then print out the list of possibilities - one per line - in the command window.
