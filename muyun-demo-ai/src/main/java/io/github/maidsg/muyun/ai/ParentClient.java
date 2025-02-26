package io.github.maidsg.muyun.ai;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/*******************************************************************
 * <pre></pre>
 * @文件名称： ParentClient.java
 * @包 路  径： io.github.maidsg.muyun.ai
 * @Copyright：wy (C) 2025 *
 * @Description:
 * @Version: V1.0
 * @Author： wy
 * @Date： 2025/2/25 23:56
 * @Modify：
 */


public interface ParentClient {
    @GET
    String get();
}
