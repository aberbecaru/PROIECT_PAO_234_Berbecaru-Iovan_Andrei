package The_Complex;

public class Sponsor {


    private int id;
    private String sponsorName;
    private String contactInformation;
    private String sponsorType;

    private int contributionAmount;

    public Sponsor(int id, String sponsorName, String contactInformation, String sponsorType, int contributionAmount) {
        this.id = id;
        this.sponsorName = sponsorName;
        this.contactInformation = contactInformation;
        this.sponsorType = sponsorType;
        this.contributionAmount = contributionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getSponsorType() {
        return sponsorType;
    }

    public void setSponsorType(String sponsorType) {
        this.sponsorType = sponsorType;
    }

    public double getContributionAmount() {
        return contributionAmount;
    }

    public void setContributionAmount(int contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public String toCSV(){
        return id+ ","+sponsorName + ',' + contactInformation + ',' + sponsorType + ',' + contributionAmount;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "sponsorName='" + sponsorName + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                ", sponsorType='" + sponsorType + '\'' +
                ", contributionAmount=" + contributionAmount +
                '}';
    }
}
