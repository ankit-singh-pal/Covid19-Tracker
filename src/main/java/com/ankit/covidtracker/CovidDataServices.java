package com.ankit.covidtracker;

import com.ankit.covidtracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CovidDataServices {

    private String url="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationStats> allstats =new ArrayList<>();

    public List<LocationStats> getAllstats() {
        return allstats;
    }

    @PostConstruct
    @Scheduled(cron="* * 1 * * *")
              // "second min hour day month year"
    public void fetchVirusData() throws IOException, InterruptedException {
        List<LocationStats> newstats =new ArrayList<>();

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()          // make the request to that url
                                         .uri(URI.create(url))
                                         .build();

        HttpResponse<String> httpResponse=client.send(request, HttpResponse.BodyHandlers.ofString()); // get a string

        //System.out.println(httpResponse.body()); // for check

        StringReader csvReader =new StringReader(httpResponse.body()); // raed via StringReader

        // Parse it using open source library for parsing csv which patch csv
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvReader);

        // looping through a record and pulling out value via column
        for (CSVRecord record : records) {
            LocationStats ls=new LocationStats();
            ls.setState(record.get("Province/State"));
            ls.setCountry(record.get("Country/Region"));
            int newcase=Integer.parseInt(record.get(record.size()-1)); // last is the current date
            int oldcase=Integer.parseInt(record.get(record.size()-2));

            ls.setLatestDateCase(newcase);
            ls.setDiffOfCase(newcase-oldcase);

           // System.out.println(ls);
            newstats.add(ls);
        }


        this.allstats=newstats;

    }

}
