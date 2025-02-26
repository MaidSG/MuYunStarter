package io.github.maidsg.muyun.ai;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

/*******************************************************************
 * <pre></pre>
 * @文件名称： ChildClient.java
 * @包 路  径： io.github.maidsg.muyun.ai
 * @Copyright：wy (C) 2025 *
 * @Description:
 * @Version: V1.0
 * @Author： wy
 * @Date： 2025/2/25 23:57
 * @Modify：
 */

public interface ChildClient extends ParentClient { // No explicit @RegisterRestClient

    String getChild();
}
