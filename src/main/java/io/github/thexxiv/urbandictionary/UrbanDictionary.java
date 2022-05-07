/*
 * Copyright (c) 2022 XXIV
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.thexxiv.urbandictionary;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class UrbanDictionary {

    private static String http(String endpoint) {
        try {
            URL url = new URL(String.format("https://api.urbandictionary.com/v0/%s", endpoint));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader;
            if (100 <= connection.getResponseCode() && connection.getResponseCode() <= 399) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            StringBuilder string = new StringBuilder();
            String output;
            while ((output = reader.readLine()) != null) {
                string.append(output);
            }
            return string.toString();
        } catch (Exception ex) {
            return null;
        }
    }


    public static List<Response> search(String input, long page) {
        try {
            String response = http(String.format("define?term=%s&page=%d", URLEncoder.encode(input, StandardCharsets.UTF_8.toString()), page));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                BaseResponse data = gson.fromJson(response, BaseResponse.class);
                if (data.list != null && !data.list.isEmpty()) {
                    List<Response> list = new ArrayList<>(data.list);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static List<Response> random() {
        try {
            String response = http("random");
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                BaseResponse data = gson.fromJson(response, BaseResponse.class);
                if (data.list != null && !data.list.isEmpty()) {
                    List<Response> list = new ArrayList<>(data.list);
                    if (list.isEmpty()) {
                        return null;
                    } else {
                        return list;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static Response definitionById(long id) {
        try {
            String response = http(String.format("define?defid=%d", id));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                BaseResponse data = gson.fromJson(response, BaseResponse.class);
                if (data.list != null && !data.list.isEmpty()) {
                    return data.list.get(0);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static String toolTip(String term) {
        try {
            String response = http(String.format("tooltip?term=%s", term));
            if (response != null && response.length() != 0) {
                Gson gson = new Gson();
                JsonElement json = gson.fromJson(response, JsonElement.class);
                JsonObject data = json.getAsJsonObject();
                return data.get("string").getAsString();
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }
}