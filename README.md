# Graph-Coloring
I still don't know why this started, but this will be gone if I do finish it on accident.
# Reason for this Project
Woke up in the dead of night with an idea, why not try it, and since I know java the best, why not try in java? (I will try this in other languages that support the types, and implement it in languages that don't.)
##Initial Thoughts

The initial idea I had seemed to simple for the solution, as each graph has an adjacency matrix, why not check against that for solving the issue
**Upon starting however, the algorithm went through a few changes.**

### Iterations
##### 1st Iteration
Hypothesis : Starting with the adjacency matrix was the first step, the only question was what patterns could I find between coloring and how the adjacency matrix is filled. With my initial testing, what I noticed was that if a subset of the total amount of nodes equal to the amount of colors - 1 had the same destination, then the graph could not be considered colored with the given amount of colors.\

Result
: This is false, as a graph with the format of a square with a line through it would give you a false negative, so this implementation is not correct.\

##### 2nd Iteration
 