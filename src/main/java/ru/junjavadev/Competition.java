package ru.junjavadev;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Competition {

    private static final Comparator<Team> sortByPlace = Comparator.comparingInt(Team::getPlace);

    public static Map<String, Integer> getTeamPlaceMap(Collection<Team> teams) {

        return teams.stream()
                .sorted(sortByPlace)
                .collect(Collectors.toMap(
                        Team::getName,
                        Team::getPlace,
                        (t1, t2) -> t1,
                        LinkedHashMap::new));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Collection<Team> teams = Stream
                .iterate(1, i -> scanner.hasNextLine(), i -> i + 1)
                .map(i -> scanner.nextLine().split("\\s+"))
                .map(parts -> new Team(parts[0], Integer.parseInt(parts[1])))
                .collect(Collectors.toSet());

        getTeamPlaceMap(teams)
                .forEach((team, speaker) -> System.out.println(team + ": " + speaker));
    }
}

class Team {
    private final String name;
    private final int place;

    public Team(String name, int place) {
        this.name = name;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }
}