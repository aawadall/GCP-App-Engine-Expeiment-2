import os
import urllib

from google.appengine.api import users
from google.appengine.ext import ndb

import jinja2
import webapp2

JINJA_ENVIRONMENT = jinja2.Environment (
    loader=jinja2.FileSystemLoader(os.path.dirname(__file__)),
    extensions=['jinja2.ext.autoescape'],
    autoescape=True
)

DEFAULT_GUESBOOK_NAME = 'mock-app'

def guestbook_key(guestbook_name=DEFAULT_GUESBOOK_NAME):
    return ndb.Key('Guestbook', guestbook_name)