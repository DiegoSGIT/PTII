package com.RFIDSystem.ws.structures.request;

import java.util.ArrayList;
import java.util.List;
import com.RFIDSystem.structures.ArticlesIDS;

/**
 * Conjunta las compras en el JSON.
 * @author diego
 *
 */

public class Compras {
	public List<ArticlesIDS> articlesId;
	public Compras() {
		articlesId = new ArrayList<ArticlesIDS>();
	}
	

}
