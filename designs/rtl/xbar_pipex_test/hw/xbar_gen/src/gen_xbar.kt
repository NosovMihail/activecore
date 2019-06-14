import hwast.*
import xbar_pipex.*

fun main(args: Array<String>) {
    println("xbar: generating")

    val SLAVE_ADDR_WIDTH = 30
    val SLAVE_SPACE_SIZE = 1.shl(SLAVE_ADDR_WIDTH)
    var map = addr_map()
    for (i in 0..3) {
        map.add(slave_entry(i * SLAVE_SPACE_SIZE, SLAVE_ADDR_WIDTH))
    }

    var xbar = xbar_pipex.xbar(("xbar_pipex"),
        4,
        32,
        4,
        hw_type(VAR_TYPE.UNSIGNED, hw_dim_static(31, 0)),
        hw_type(VAR_TYPE.UNSIGNED, hw_dim_static(31, 0)),
        map)
    xbar.export_to_sv("coregen")
}