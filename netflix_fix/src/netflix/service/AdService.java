package netflix.service;

import java.util.List;

import netflix.model.AdModel;

public interface AdService {

	public boolean addAd(AdModel ad);
	public List<AdModel>allAds();
	public boolean deleteAd(int id);
	public boolean updateAd(AdModel ad);
	public AdModel getAdById(int id);
}
