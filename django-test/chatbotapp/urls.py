from django.urls import path

from . import views

# url 매핑할 것들
urlpatterns = [
    path('', views.index, name='index'),
]