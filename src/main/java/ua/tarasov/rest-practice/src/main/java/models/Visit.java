package models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public final class Visit {

    private final UUID id;
    private String name;
    private String date;
    private String city;
    private static List<Visit> visits;

    private Visit() {
        this.id = UUID.randomUUID();
    }

    public static Builder Build() {
        return new Builder();
    }

    public static List<Visit> getVisits(){
        return visits;
    }

    public static class Builder {

        private final Visit visit;

        public Builder() {
            visit = new Visit();
        }

        public Builder setName(String name) {
            visit.name = name;
            return this;
        }

        public Builder setCity(String city) {
            visit.city = city;
            return this;
        }

        public Builder setDate(String date){
            visit.date = date;
            return this;
        }

        public Visit createVisit() {
            if (visits == null){
                visits = new ArrayList<>();
            }
            visits.add(visit);
            if (visits.size() > 3) {
                visits.remove(0);
            }
            return visit;
        }
    }

    @Override
    public String toString() {
        return "Entity's.Visit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", city='" + city + '\'' +
                '}';
    }
}

