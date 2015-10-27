package com.translationexchange.samples.spring.foody.listeners;

import com.translationexchange.core.Tml;
import com.translationexchange.core.Utils;
import com.translationexchange.j2ee.listeners.TmlListener;

public class FoodyListener extends TmlListener {

	protected void configureTml() {

		Tml.getConfig().setApplication(Utils.buildMap(
			"key",		"b8206d1b982a5410f34da48490d7653fe25266f16c70482ccc953fb7264547d1",
			"token", 	"573d1cb5d207b439abdcf1cad8ff76c56b00c275fa032a69f748b34c82613e07"
		));

//		Tml.getConfig().setCache(Utils.buildMap(
//			"enabled",  true,
//	    	"class", 	"com.translationexchange.cache.Memcached",
//	        "host", 	"localhost:11211",
//	        "namespace", "c41b8ffaf8c98"
//		));


		Tml.getConfig().setCache(Utils.buildMap(
				"enabled",  false,
		    	"class", 	"com.translationexchange.cache.EHCache",
		        "namespace", "0332a07e97af3d81f6fe9723cc083df3a45fbd39d1380691c62e445c598b8d5c"
		));
	}
}
