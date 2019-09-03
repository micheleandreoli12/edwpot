package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class DaoCountryPrep {
    private Connection conn;

    public DaoCountryPrep(DataSource ds) {
        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }

    public List<Country> getAll() {
        List<Country> results = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from regions");

            while (rs.next()) {
                results.add(new Country(rs.getString("REGION_ID"), rs.getString("REGION_NAME")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }
    public List<Country> getCountries(String query, int a) {
        List<Country> results = new ArrayList<>();

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,a);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                results.add(new Country(rs.getString("COUNTRY_ID"), rs.getString("COUNTRY_NAME")));
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }
}