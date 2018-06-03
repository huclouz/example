package com.huttchang.example.providers;

import com.huttchang.example.models.Book;
import com.huttchang.example.models.KakaoBookResponse;
import com.huttchang.example.models.KakaoParameter;
import com.huttchang.example.models.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * 프로젝트명    : example
 * 패키지명      : com.huttchang.example.providers
 * 작성 및 소유자 : hucloud(huttchang@gmail.com)
 * 최초 생성일   : 2018. 5. 30.
 */
@Component("kakaoAPIProvider")
public class KaKaoBookAPIProvider implements SearchProvider<KakaoParameter, Book> {
    // 카카오호스트
    @Value("${api.kakako.bookapi.uri}")
    private String kakaoAPIHost;
    // 카카오 appKey
    @Value("${api.kakako.api.appkey}")
    private String kakaoAppKey;

    /**
     * 카카오 서치 API
     * @param option
     * @return
     * @throws Exception
     */
    @Override
    public List<Book> search(KakaoParameter option) throws Exception {

        try {
            RestTemplate template = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, String.format("KakaoAK %s", kakaoAppKey));
            RequestEntity httpEntity
                    = new RequestEntity(
                            headers, HttpMethod.GET, new URI(kakaoAPIHost+"?"+option.generateQueryString()));
            ResponseEntity<KakaoBookResponse> t = template.exchange(httpEntity, KakaoBookResponse.class);
            option.setEnd(t.getBody().getMeta().isEnd());
            option.setTotalCount(t.getBody().getMeta().getTotalCount());
            return t.getBody().getDocuments();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * ISBN 사용시 여러개의 데이터 출력될 수 있으므로 위의 search 사용
     * @param key
     * @param value
     * @return
     */
    @Deprecated
    @Override
    public Book detail(String key,String value) {
        return null;
    }
}
