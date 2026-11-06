package mapajuego
import unidades.Caballero

class PanelTest extends munit.FunSuite:
  var panel: Panel = null

  override def beforeEach(context: BeforeEach): Unit =
    panel = new Panel(2,3)

  test("panel created with given coordenates"):
    assert(panel.x==2)
    assert(panel.y==3)
  test("new panel, doesnt have units"):
    assert(panel.UnitsInPanel.isEmpty)

  test("Un Panel puede contener unidades"):
    val caballero = new Caballero("A", 100, 15, 70)
    panel.addUnit(caballero)
    assert(panel.UnitsInPanel.head == caballero)

  test("Un Panel nuevo no tiene paneles aledaños"):
    assert(panel.NeighboringPanel.isEmpty)

  test("Un Panel reconoce como aledaño a un panel agregado"):
    val vecino = new Panel(2, 4)
    panel.AddNeighbor(vecino)
    assert(panel.NeighboringPanel.contains(vecino))