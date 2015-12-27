package smarthome.model;

import smarthome.managers.ThingManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Ivan.Balabanov on 27.12.2015.
 */
public class JdbcThingDAO implements DAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertThing(Thing thing){

        String sql = "INSERT INTO things " +
                "(id, name, power) VALUES (?, ?, ?)";
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thing.getId());
            ps.setString(2, thing.getName());
            ps.setInt(3, thing.getPower());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public Thing findByThingId(int thingId) {

        String sql = "SELECT * FROM things WHERE id=" + thingId;
        Connection conn = null;
        Thing thing = ThingManager.getThingInstance(thingId,"",0);
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                thing.setId(rs.getInt("id"));
                thing.setName(rs.getString("name"));
                thing.setPower(rs.getInt("power"));
            }
            rs.close();
            ps.close();
            return thing;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

    public ArrayList<Thing> selectThings() {

        String sql = "SELECT * FROM things";

        Connection conn = null;
        ArrayList<Thing> things = new ArrayList<Thing>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thing thing = new Thing(rs.getInt("id"),rs.getString("name"),rs.getInt("power"));
                things.add(thing);
            }
            rs.close();
            ps.close();
            return things;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }

    }

}