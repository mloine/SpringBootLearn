package com.xyk.elastic;

import com.xyk.elastic.bean.Article;
import com.xyk.elastic.bean.Book;
import com.xyk.elastic.repository.BookReposity;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {
	@Autowired
	JestClient jestClient;

	@Autowired
	BookReposity bookReposity;

	@Test
	public void test2(){
//		Book book = new Book();
//		book.setId (1);
//		book.setBookName ("西游记");
//		book.setAuthor ("薛勇康");
//
//		bookReposity.index (book);

		List<Book> books =
				bookReposity.findByBookNameLike ("游");

		System.out.println (books);

	}

	@Test
	public void contextLoads() {
		//1.给es中索引 保存一个文档
		Article article = new Article ();

		article.setId (1);
		article.setAuthor ("zhangsan");
		article.setContent ("Hello World");
		article.setTitle ("好消息");

		//构建一个索引功能 指定数据 的索引 和 类型
		Index build = new Index.Builder (article).index ("xyk").type ("news").build ();

		try {
			//执行
			jestClient.execute (build);
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

	@Test
	public void search(){
		String json_search = "{\n" +
				"    \"query\" : {\n" +
				"        \"match\" : {\n" +
				"            \"content\" : \"Hello World\"\n" +
				"        }\n" +
				"    }\n" +
				"}";
		Search build = new Search.Builder (json_search).addIndex ("xyk").addType ("news").build ();

		try {
			SearchResult execute = jestClient.execute (build);
			System.out.println (execute.getJsonString ());
		} catch (IOException e) {
			e.printStackTrace ();
		}
	}

}
