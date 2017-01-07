package com.kerr.twilio;

import java.io.IOException;

/**
 * Created by allankerr on 2017-01-06.
 */
class PostRequest extends Request {

    PostRequest(Request.Builder builder) {
        super(builder);
    }

    public StringBuffer fetch() throws IOException {
        /*HttpURLConnection connection = super.openConnection(url);
        System.out.println(url);
        try {
            connection.setRequestMethod(RequestMethod.GET.name());
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        }
        connection.setDoOutput(true);

        int respCode = connection.getResponseCode();
        if (respCode == HttpURLConnection.HTTP_OK) {

            StringBuffer response = new StringBuffer();
            String line;

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            return response;
        } else {
            throw new HTTPException(respCode);
        }*/
        return null;
    }

}
