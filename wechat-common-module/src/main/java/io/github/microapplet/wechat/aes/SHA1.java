/*
 * Copyright 2014-2024 <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.microapplet.wechat.aes;

import java.security.MessageDigest;
import java.util.Arrays;


/**
 * 计算公众平台的消息签名接口
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
public class SHA1 {

	/**
	 * 用SHA1算法生成安全签名
	 * @return 安全签名
	 */
	public static String getSHA1(String... args) throws AesException {
		try {
			String[] array = args.clone();
			StringBuilder sb = new StringBuilder();
			// 字符串排序
			Arrays.sort(array);
            for (String s : array) {
                sb.append(s);
            }
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuilder hexStr = new StringBuilder();
			String shaHex;
            for (byte b : digest) {
                shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    hexStr.append(0);
                }
                hexStr.append(shaHex);
            }
			return hexStr.toString();
		} catch (Exception e) {
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
}