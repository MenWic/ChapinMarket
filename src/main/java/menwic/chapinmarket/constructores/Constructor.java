package menwic.chapinmarket.constructores;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Constructor {

    public Object construirLista(ResultSet resultado) throws SQLException;

    public Object construirObjeto(ResultSet resultado) throws SQLException;
}
