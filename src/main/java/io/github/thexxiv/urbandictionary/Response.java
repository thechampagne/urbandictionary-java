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

import java.util.ArrayList;

public class Response {
    public String definition;
    public String permalink;
    public int thumbs_up;
    public ArrayList<String> sound_urls;
    public String author;
    public String word;
    public int defid;
    public String written_on;
    public String example;
    public int thumbs_down;

    @Override
    public String toString() {
        return "Response{" +
                "definition='" + definition + '\'' +
                ", permalink='" + permalink + '\'' +
                ", thumbs_up=" + thumbs_up +
                ", sound_urls=" + sound_urls +
                ", author='" + author + '\'' +
                ", word='" + word + '\'' +
                ", defid=" + defid +
                ", written_on='" + written_on + '\'' +
                ", example='" + example + '\'' +
                ", thumbs_down=" + thumbs_down +
                '}';
    }
}

class BaseResponse {
    ArrayList<Response> list;
}