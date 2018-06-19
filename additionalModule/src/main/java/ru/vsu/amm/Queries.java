package ru.vsu.amm;

public class Queries {
    public static final String SELECT_AMOUNT = "SELECT  count(*) as amount FROM parcking_place";
    public static final String UPDATE_SPOTS = "UPDATE parcking_place SET num_of_free_spots = ? where place_id = ?";
}
