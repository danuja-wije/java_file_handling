package netflix.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import netflix.model.AdModel;
import netflix.utill.DBconnectionUtill;

public class AdServiceImpl implements AdService {
	private static Connection connection = null;
	private static Statement statement = null;
	private static PreparedStatement prearedStatement = null;
	private static List<AdModel> adList = null;
	private static ResultSet resultSet = null;
	private static AdModel ad = null;
	@Override
	public boolean addAd(AdModel ad) {
		boolean flag = false;
		System.out.println(ad.getPath());
		// String sql = "INSERT INTO
		// advertisement(username,ad_name,category,period,filname)
		// VALUES('"+ad.getUserName() + "','"+ ad.getCategory() + "','" + ad.getPeriod()
		// + "','nothing Yet')";
		String sql = "INSERT INTO `advertisement` (`ad_id`, `username`, `ad_name`, `category`, `period`, `filename` ,`thumbnail`) VALUES (NULL, '"
				+ ad.getUserName() + "', '" + ad.getAdName() + "', '" + ad.getCategory() + "', '" + ad.getPeriod()
				+ "', '" + ad.getPath() + "' ,'" + ad.getThumb() + "')";

		try {
			connection = DBconnectionUtill.createConnection();

			prearedStatement = connection.prepareStatement(sql);
			prearedStatement.executeUpdate();

			flag = true;
		} catch (SQLException ex) {
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
			}
		}

		return flag;
	}

	@Override
	public List<AdModel> allAds() {
		adList = new ArrayList<AdModel>();

		String sql = "SELECT * FROM `advertisement`";

		try {

			connection = DBconnectionUtill.createConnection();

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				//ad = new AdModel(resultSet.getString("ad_name"), resultSet.getString("username"),resultSet.getString("category"),resultSet.getString("Content"), resultSet.getString("period"), resultSet.getString("filename"),resultSet.getString("thumbnail"));
				ad = new AdModel();
				
				ad.setAdName(resultSet.getString("ad_name"));
				ad.setCategory(resultSet.getString("category"));
				ad.setPath(resultSet.getString("filename"));
				ad.setPeriod(resultSet.getString("period"));
				ad.setThumb(resultSet.getString("thumbnail"));
				ad.setUserName(resultSet.getString("username"));
				ad.setId(resultSet.getInt("ad_id"));

				adList.add(ad);
			}

		} catch (SQLException ex) {
			//log.log(Level.SEVERE, ex.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				//log.log(Level.SEVERE, ex.getMessage());
			}
		}

		return adList;
	}

	@Override
	public boolean deleteAd(int id) {
		boolean flag = false;
		//declare query
		String sql = "DELETE FROM `advertisement` WHERE `advertisement`.`ad_id` ="+id;

		try {
			connection = DBconnectionUtill.createConnection();//open connection
			prearedStatement = connection.prepareStatement(sql);
			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return flag;
	}

	@Override
	public boolean updateAd(AdModel ad) {
		boolean flag = false;

		//declare query

		String sql = "UPDATE `advertisement` SET `ad_name` = '"+ad.getAdName()+"', `category` = '"+ad.getCategory()+"', `period` = '"+ad.getPeriod()+"', `filename` = '"+ad.getPath()+"', `thumbnail` = '"+ad.getThumb()+"' WHERE `advertisement`.`ad_id` ="+ad.getId();

		try {
			connection = DBconnectionUtill.createConnection();//open connection

			prearedStatement = connection.prepareStatement(sql);


			prearedStatement.executeUpdate();

			flag = true;
		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}
		return flag;
	}

	@Override
	public AdModel getAdById(int id) {
		try {
			//declare query
			String sql = "SELECT * FROM `advertisement` WHERE `advertisement`.`ad_id` ="+id;

			connection = DBconnectionUtill.createConnection();//open connection

			statement = connection.createStatement();

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				ad = new AdModel();
				
				ad.setAdName(resultSet.getString("ad_name"));
				ad.setCategory(resultSet.getString("category"));
				ad.setPath(resultSet.getString("filename"));
				ad.setPeriod(resultSet.getString("period"));
				ad.setThumb(resultSet.getString("thumbnail"));
				ad.setUserName(resultSet.getString("username"));
				ad.setId(resultSet.getInt("ad_id"));
				
			}

		}  catch (SQLException e) {
			//log.log(Level.SEVERE, e.getMessage());
		} finally {
			//close the connection and preparedstatement
			try {
				if (prearedStatement != null) {
					prearedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				//log.log(Level.SEVERE, e.getMessage());
			}
		}

		return ad;
	}

}
