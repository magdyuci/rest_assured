import java.util.List;

public class FootBallTeam {
	private Area area;
	private String venue;
	private String website;
	private String address;
	private String crestUrl;
	private String tla;
	private int founded;
	private String lastUpdated;
	private String clubColors;
	private List<SquadItem> squad;
	private String phone;
	private String name;
	private List<ActiveCompetitionsItem> activeCompetitions;
	private int id;
	private String shortName;
	private String email;

	public void setArea(Area area){
		this.area = area;
	}

	public Area getArea(){
		return area;
	}

	public void setVenue(String venue){
		this.venue = venue;
	}

	public String getVenue(){
		return venue;
	}

	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public String getAddress(){
		return address;
	}

	public void setCrestUrl(String crestUrl){
		this.crestUrl = crestUrl;
	}

	public String getCrestUrl(){
		return crestUrl;
	}

	public void setTla(String tla){
		this.tla = tla;
	}

	public String getTla(){
		return tla;
	}

	public void setFounded(int founded){
		this.founded = founded;
	}

	public int getFounded(){
		return founded;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setClubColors(String clubColors){
		this.clubColors = clubColors;
	}

	public String getClubColors(){
		return clubColors;
	}

	public void setSquad(List<SquadItem> squad){
		this.squad = squad;
	}

	public List<SquadItem> getSquad(){
		return squad;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActiveCompetitions(List<ActiveCompetitionsItem> activeCompetitions){
		this.activeCompetitions = activeCompetitions;
	}

	public List<ActiveCompetitionsItem> getActiveCompetitions(){
		return activeCompetitions;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setShortName(String shortName){
		this.shortName = shortName;
	}

	public String getShortName(){
		return shortName;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}
