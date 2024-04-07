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

import lombok.Getter;

/**
 * ASE Exception
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024/3/25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
@Getter
public class AesException extends Exception {
	public final static int ValidateSignatureError = -40001;
	public final static int ParseXmlError = -40002;
	public final static int ComputeSignatureError = -40003;
	public final static int IllegalAesKey = -40004;
	public final static int ValidateAppidError = -40005;
	public final static int EncryptAESError = -40006;
	public final static int DecryptAESError = -40007;
	public final static int IllegalBuffer = -40008;

	private final int code;

	private static String getMessage(int code) {
		switch (code) {
			case ValidateSignatureError:
				return "签名验证错误";
			case ParseXmlError:
				return "xml解析失败";
			case ComputeSignatureError:
				return "sha加密生成签名失败";
			case IllegalAesKey:
				return "SymmetricKey非法";
			case ValidateAppidError:
				return "appid校验失败";
			case EncryptAESError:
				return "aes加密失败";
			case DecryptAESError:
				return "aes解密失败";
			case IllegalBuffer:
				return "解密后得到的buffer非法";
			default:
				return null; // cannot be
		}
	}


	public AesException(int code) {
		super(getMessage(code));
		this.code = code;
	}
}