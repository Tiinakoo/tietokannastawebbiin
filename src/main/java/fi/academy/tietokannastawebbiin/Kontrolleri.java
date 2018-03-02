package fi.academy.tietokannastawebbiin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class Kontrolleri {
    @Autowired
    JdbcTemplate jdbc; //ottaa yhteyden tietokantaan, joka on määritelty application.properties tiedostossa

    @GetMapping("/index")
    public String naytamaat(Model model){
        List<String> maat = jdbc.queryForList(
                "select name from country",
                String.class);
        model.addAttribute("maat", maat);
        return "index";
    }

    @RequestMapping("/maatietoja")
    public String maatiedot(Model model){
        List<Maa> maatiedot = jdbc.query(
                "select country.name, country.LocalName, city.name, country.population from country join city on country.capital = city.id",
                new RowMapper<Maa>() {
                    public Maa mapRow(ResultSet tulosjoukko, int indeksi)
                        throws SQLException {
                        Maa maat = new Maa(
                                tulosjoukko.getString("country.name"),
                                tulosjoukko.getString("country.localname"),
                                tulosjoukko.getString("city.name"),
                                tulosjoukko.getInt("country.population"));
                        return maat;
                    }
                    });

        model.addAttribute("maatiedot", maatiedot);
        return "maatietoja";
    }
}
