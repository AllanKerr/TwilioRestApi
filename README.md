# TwilioRestApi

This unoffical Twilio API is designed to interface with the Twilio REST API through google app engine. It was created due to problems with the official Twilio Java API caused by multithreading in the HTTP library. This library uses HttpURLConnection which is officially supported by google app engine.

For reference on the functionality of API calls visit https://www.twilio.com/docs/api/rest. Not all API calls have been implemented but new ones are constantly being added based on what is currently required. New API calls can be added easily by subclassing the TwilioRequest class.

**Disclaimer:** This is an unofficial API. I am not affiliated with Twilio in any way.
