package cl.uchile.dcc
package PatronObserver

trait Observer[T] {
  def update(subject: Subject[T], response: T): Unit
}