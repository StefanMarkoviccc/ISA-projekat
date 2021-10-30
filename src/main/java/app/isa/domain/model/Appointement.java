package app.isa.domain.model;

import java.util.Date;

public class Appointement extends BaseEntity{

    private House house;

    private Room room;

    private Date date;

    private boolean isAction=false;
}
