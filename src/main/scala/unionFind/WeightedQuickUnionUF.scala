package unionFind

class WeightedQuickUnionUF(val n: Int) {
  private val id = Array.ofDim[Int](n)
  private val sz = Array.ofDim[Int](n)
  private var count = n

  // set index of each obj to itself
  for (i <- 0 until n) id(i) = i
  // set index of each obj to 1
  for (i <- 0 until n) sz(i) = 1

  // chase parent pointers until reach root
  def root(i: Int): Int = {
    var tmp = i
    while (tmp != id(tmp)) tmp = id(tmp)
    tmp
  }

  // check if p & q have same root
  def connected(p: Int, q: Int): Boolean = root(p) == root(q)

  // change root of p to point to root of q
  def union(p: Int, q: Int): Unit = {
    val i = root(p)
    val j = root(q)
    if (i == j) return

    if (sz(i) < sz(j)) { id(i) = j; sz(j) += sz(i) }
    else               { id(j) = i; sz(i) += sz(j) }
    count = count -1
  }
}

object WeightedQuickUnionUF {
  def main(args: Array[String]) {
    val weightedQuickUnionUF = new WeightedQuickUnionUF(10)

    weightedQuickUnionUF.union(4, 3)
    weightedQuickUnionUF.union(3, 8)
    weightedQuickUnionUF.union(6, 5)
    weightedQuickUnionUF.union(9, 4)
    weightedQuickUnionUF.union(2, 1)
    assert(weightedQuickUnionUF.connected(8, 9))
    assert(!weightedQuickUnionUF.connected(5, 4))
    weightedQuickUnionUF.union(5, 0)
    weightedQuickUnionUF.union(7, 2)
    weightedQuickUnionUF.union(6, 1)
    weightedQuickUnionUF.union(7, 3)
  }
}

