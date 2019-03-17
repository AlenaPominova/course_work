package ru.vsu.amm.queries;

public class UserQueries {

    public static final String CREATE_USER = "INSERT INTO public.user(" +
                                                   " user_id, email, password, fio, description, role_id)" +
                                                   " VALUES (?, ?, ?, ?, ?, ?)";
    public static final String FIND_BY_ID = "SELECT U.* FROM public.USER U where U.user_id = ?";
    public static final String FIND_BY_EMAIL = "SELECT U.* FROM public.USER U where U.email = ?";
    public static final String GET_ALL = "select * from public.USER";
    public static final String UPDATE_USER = "UPDATE public.user " +
                                                   " SET email=?, password=?, fio=?, description=?, role_id = ? " +
                                                   " WHERE user_id = ?;";
    public static final String DELETE_USER = "DELETE FROM public.user" +
                                                    " WHERE user_id = ?";
    public static final String GET_ROLE = "SELECT U.email, R.name " +
                                            "FROM public.\"user\" U " +
                                            "join role R " +
                                            " on U.role_id = R.role_id " +
                                            "where U.email = ?;";
    public static final String GET_FAV_PLACES = "select P.* " +
                                                      " from favorite_places F " +
                                                      " left join parcking_place P " +
                                                      " on F.parking_place_id = P.place_id " +
                                                      " where F.user_id = ?;";
    public static final String AUTH_QUERY_USER = "select U.email, U.password" +
                                                    "from user U " +
                                                    "where U.email = ?";
    public static final String AUTH_QUERY_ROLE = "select U.email, R.name " +
                                                    "from \"user\" U " +
                                                    "join role R " +
                                                    " on R.role_id = U.role_id " +
                                                    "where U.email = ?";
}
