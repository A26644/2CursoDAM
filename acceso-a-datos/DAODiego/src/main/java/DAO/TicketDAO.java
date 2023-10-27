package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Empresa;
import model.Ticket;
import sql.MotorPostgres;

public class TicketDAO implements IDAO<Ticket> {
    ArrayList<Ticket> lstTicket;
    MotorPostgres pg = new MotorPostgres();
    PreparedStatement PpSt;
    String UPDATE = "UPDATE EMPRESA SET EMPRESA_NOMBRE = ?, EMPRESA_CIF = ?, EMPRESA_ DIRECCIONPOSTAL = ?, EMPRESA_DIRECCIONWEB = ?, EMPRESA_TELEFONO = ? WHERE EMPRESA_ID = ?";

    @Override
    public ArrayList<Ticket> find(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public ArrayList<Ticket> findAll() {
        try {
            lstTicket = new ArrayList<>();
            String sql = "SELECT * FROM EMPRESA";
            ResultSet rs = pg.executeQuery(sql);
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("TICKET_ID"));
                ticket.setTipoCompra(rs.getInt("TICKET_TIPOCOMPRA"));
                ticket.setTipoTarjeta(rs.getInt("TICKET_TIPOTARJETA"));
                ticket.setTitularTarjeta(rs.getString("TICKET_TITULAR"));
                ticket.setNumeroTarjeta(rs.getInt("TICKET_NUMERO"));
                ticket.setFechaDevolucion(rs.getDate("TICKET_DEVOLUCION"));
                lstTicket.add(ticket);
            }
            return lstTicket;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int update(Ticket bean) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
