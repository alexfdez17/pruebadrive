
package aiss.model.flickr;


public class Dates {

    private String posted;
    private String taken;
    private Integer takengranularity;
    private Integer takenunknown;
    private String lastupdate;

    public String getPosted() {
        return posted;
    }

    public void setPosted(String posted) {
        this.posted = posted;
    }

    public String getTaken() {
        return taken;
    }

    public void setTaken(String taken) {
        this.taken = taken;
    }

    public Integer getTakengranularity() {
        return takengranularity;
    }

    public void setTakengranularity(Integer takengranularity) {
        this.takengranularity = takengranularity;
    }

    public Integer getTakenunknown() {
        return takenunknown;
    }

    public void setTakenunknown(Integer takenunknown) {
        this.takenunknown = takenunknown;
    }

    public String getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(String lastupdate) {
        this.lastupdate = lastupdate;
    }

}
