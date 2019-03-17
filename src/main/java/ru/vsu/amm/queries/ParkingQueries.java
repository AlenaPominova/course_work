package ru.vsu.amm.queries;

public class ParkingQueries {

    public static String CREATE_PARKIING = "INSERT INTO public.parcking_place(\" +\n" +
            " place_id, latitude, longitude, price, is_paid, open_time, close_time, " +
            " num_of_free_spots, address, description) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static String FIND_BY_ID = "SELECT P.* FROM public.parcking_place P where P.place_id = ?";
    public static String FIND_BY_ADDRESS = "SELECT P.* FROM public.parcking_place P where P.address = ?";
    public static String GET_ALL = "select P.* from public.parcking_place P";
    public static String DELETE_PARKING = "DELETE FROM public.parcking_place" +
            " WHERE place_id = ?;";
    public static String UPDATE_PARKING = "UPDATE public.parcking_place \" +\n" +
            " SET latitude=?, longitude=?, price = ?, is_paid=?, open_time=?, " +
            " close_time=?, num_of_free_spots=?, address=?, " +
            " description=? " +
            " WHERE place_id = ?;";
}
