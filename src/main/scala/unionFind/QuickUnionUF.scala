package unionFind

class QuickUnionUF(val n: Int) {
  private val id = Array.ofDim[Int](n)
  // set index of each obj to itself
  for (i <- 0 until n) id(i) = i

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
    id(i) = j
  }
}

object QuickUnionUF {
  def main(args: Array[String]) {
    val quickUnionUF = new QuickUnionUF(10)

    quickUnionUF.union(4, 3)
    quickUnionUF.union(3, 8)
    quickUnionUF.union(6, 5)
    quickUnionUF.union(9, 4)
    quickUnionUF.union(2, 1)
    assert(quickUnionUF.connected(8, 9))
    assert(!quickUnionUF.connected(5, 4))
    quickUnionUF.union(5, 0)
    quickUnionUF.union(7, 2)
    quickUnionUF.union(6, 1)
    quickUnionUF.union(7, 3)
  }
}