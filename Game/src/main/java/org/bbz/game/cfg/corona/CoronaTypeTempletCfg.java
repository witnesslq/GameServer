package org.bbz.game.cfg.corona;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模版配置
 * @author liukun
 * 2014-3-28 13:31:20
 */
public class CoronaTypeTempletCfg {
	private static final Map<Integer,CoronaTypeTemplet> coronaTypeTemplets = new HashMap<Integer, CoronaTypeTemplet>();


	static{
		init();

	}
	private static final String FILE = "./Game/src/main/resources/xml/corona/coronaType.xml";



	private static void init(){

		SAXBuilder builder = new SAXBuilder();
		Document document;
		try {
			document = builder.build( FILE );
			Element root = document.getRootElement();
			List<?> list = root.getChildren( "CoronaType" );

			for (Object o : list) {
				CoronaTypeTemplet templet = new CoronaTypeTemplet( (Element) o );
				CoronaTypeTemplet temp = coronaTypeTemplets.put( templet.getId(), templet );
				if( temp != null ){
					throw new RuntimeException( "CoronaTypeTemplet id [" + temp.getId() + "] 重复了" );
				}

			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println( "CoronaTypeTemplet xml配置文件解析完毕" );
	}


	/**
	 * 通过id获取CoronaTypeTemplet的引用
	 * @param   templetId   id
	 * @return  返回一个引用
	 */
	public static CoronaTypeTemplet getCoronaTypeTempletById( int templetId ){
		return coronaTypeTemplets.get( templetId );
	}

	/*自定义代码开始*//*自定义代码结束*/

	public static void main(String[] args) {

		int id = 1;
		System.out.println( getCoronaTypeTempletById( id ) );
	}
}
