from turtle import title
from django.db import models
from django.contrib.auth.models import User

# Create your models here.
class Book(models.Model):
    user=models.ForeignKey(User,on_delete=models.CASCADE,null=True,blank=True)
    title= models.CharField(max_length=200)
    author=models.CharField(max_length=200)
    pages=models.IntegerField()

    def __str__(self):
        return self.title
    class Meta:
        ordering=['title']