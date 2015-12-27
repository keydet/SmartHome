package smarthome.model;

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
    public DataSource getDataSource() {
        return this.dataSource;
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
        Thing thing = new Thing(thingId,"",0);
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

    public ArrayList<Thing> findByZone(Zone zone) {

        String sql = "SELECT things.id,things.name,things.power,zones.zoneId,zones.thingId " +
                "FROM things,zones WHERE things.id=zones.zoneId AND zones.zoneId=" + zone.getId() +
                " GROUP BY things.id,things.name,things.power";

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

    public ArrayList<Zone> selectZones() {

        String sql = "SELECT * FROM zones";

        Connection conn = null;
        ArrayList<Zone> zones = new ArrayList<Zone>();

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Zone zone = new Zone(rs.getInt(1),rs.getInt(2),rs.getString(3));
                zones.add(zone);
            }
            rs.close();
            ps.close();
            return zones;
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
