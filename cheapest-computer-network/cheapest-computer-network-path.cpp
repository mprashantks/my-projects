/**
 * UnionFind/Disjoint Set data structure implementation.
 **/

#include <iostream>


class UnionFind {

  private:

    // The number of elements in this union find
    int size;

    // Used to track the size of each of the component
    int *sz;

    // id[i] points to the parent of i, if id[i] = i then i is a root node
    int *id;

    // Tracks the number of components in the union find
    int numComponents;



  public:

    UnionFind(int size) {

      if (size <= 0)
        return;

      this->size = numComponents = size;
      sz = new int[size];
      id = new int[size];

      for(int i = 0; i < size; i++) {
        id[i] = i; // Link to itself (self root)
        sz[i] = 1; // Each component is originally of size one
      }

    }

    // Find which component/set 'p' belongs to, takes amortized constant time.
    int find(int p) {

      // Find the root of the component/set
      int root = p;
      while( root != id[root] )
        root = id[root];

      // Compress the path leading back to the root.
      // Doing this operation is called "path compression"
      // and is what gives us amortized time complexity.
      while(p != root) {
        int next = id[p];
        id[p] = root;
        p = next;
      }

      return root;

    }

    // This is an alternative recursive formulation for the find method
    // public int find(int p) {
    //   if (p == id[p]) return p;
    //   return id[p] = find(id[p]);
    // }

    // Return whether or not the elements 'p' and
    // 'q' are in the same components/set.
    bool connected(int p, int q) {
      return find(p) == find(q);
    }

    // Return the size of the components/set 'p' belongs to
    int componentSize(int p) {
      return sz[find(p)];
    }

    // Return the number of elements in this UnionFind/Disjoint set
    int sizeSet() {
      return size;
    }

    // Returns the number of remaining components/sets
    int components() {
      return numComponents;
    }

    // Unify the components/sets containing elements 'p' and 'q'
    void unify(int p, int q) {

      int root1 = find(p);
      int root2 = find(q);

      // These elements are already in the same group!
      if (root1 == root2) return;

      // Merge smaller component/set into the larger one.
      if (sz[root1] < sz[root2]) {
        sz[root2] += sz[root1];
        id[root1] = root2;
      } else {
        sz[root1] += sz[root2];
        id[root2] = root1;
      }

      // Since the roots found are different we know that the
      // number of components/sets has decreased by one
      numComponents--;

    }

};
