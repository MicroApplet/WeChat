/*
 * Copyright 2014-2025 <a href="mailto:asialjim@qq.com">Asial Jim</a>
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
package com.asialjim.microapplet.wechat.encryt.official.aes;

import com.asialjim.microapplet.wechat.encryt.official.aes.AesException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.Objects;

/**
 * 提供提取消息格式中的密文及生成回复消息格式的接口
 *
 * @author <a href="mailto:asialjim@hotmail.com">Asial Jim</a>
 * @version 1.0.0
 * @since 2024 07 25, &nbsp;&nbsp; <em>version:1.0.0</em>
 */
public class XMLParse {

    /**
     * 提取出xml数据包中的加密消息
     *
     * @param xmltext 待提取的xml字符串
     * @return 提取出的加密消息字符串
     */
    public static String[] extract(String xmltext) throws AesException {
        String[] result = new String[3];
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(xmltext);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            NodeList nodelist1 = root.getElementsByTagName("Encrypt");
            result[0] = "" + Objects.nonNull(nodelist1.item(0));
            // 明文模式
            if (Objects.isNull(nodelist1.item(0)))
                result[1] = xmltext;
            else
                result[1] = nodelist1.item(0).getTextContent();

            NodeList nodelist2 = root.getElementsByTagName("ToUserName");
            result[2] = nodelist2.item(0).getTextContent();
            return result;
        } catch (Exception e) {
            //e.printStackTrace();
            throw new AesException(AesException.ParseXmlError);
        }
    }

    /**
     * 生成xml消息
     *
     * @param encrypt   加密后的消息密文
     * @param signature 安全签名
     * @param timestamp 时间戳
     * @param nonce     随机字符串
     * @return 生成的xml字符串
     */
    public static String generate(String encrypt, String signature, String timestamp, String nonce) {

        String format = "<xml><Encrypt><![CDATA[%1$s]]></Encrypt><MsgSignature><![CDATA[%2$s]]></MsgSignature><TimeStamp>%3$s</TimeStamp><Nonce><![CDATA[%4$s]]></Nonce></xml>";
        return String.format(format, encrypt, signature, timestamp, nonce);
    }
}
