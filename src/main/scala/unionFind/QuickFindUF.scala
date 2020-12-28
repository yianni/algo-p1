package unionFind

class QuickFindUF(n: Int) {
  private val ids = Array.ofDim[Int](n)
  // set index of each obj to itself
  for (a <- 0 until n) ids(a) = a

  // check if p & q are in the same component
  def connected(p: Int, q: Int): Boolean =
    ids(p) == ids(q)

  // change all entries w/ id(p) to id(q)
  def union(p: Int, q: Int): Unit = {
    val pId = ids(p)
    val qId = ids(q)

    for (i <- ids.indices) if (ids(i) == pId) ids(i) = qId
  }

}

object QuickFindUF {
  def main(args: Array[String]) {
    val quickFindUF = new QuickFindUF(10)

    quickFindUF.union(4, 3)
    quickFindUF.union(3, 8)
    quickFindUF.union(6, 5)
    quickFindUF.union(9, 4)
    quickFindUF.union(2, 1)
    assert(quickFindUF.connected(8, 9))
    assert(!quickFindUF.connected(5, 4))
    quickFindUF.union(5, 0)
    quickFindUF.union(7, 2)
    quickFindUF.union(6, 1)
    quickFindUF.union(7, 3)
  }
}