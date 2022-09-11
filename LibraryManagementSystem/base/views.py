from re import search
from turtle import title
from django.shortcuts import render, redirect
from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from django.views.generic.edit import CreateView , UpdateView, DeleteView ,FormView
from django.urls import reverse_lazy
from django.contrib.auth.views import LoginView
from django.contrib.auth.forms import UserCreationForm
from .forms import CustomUserCreationForm
from django.contrib.auth import login
from django.contrib.auth.mixins import LoginRequiredMixin
from base.models import Book
class CustomLoginView(LoginView):
    template_name='base/login.html'
    fields='__all__'
    redirect_authenticated_user= True
    def get_success_url(self):
        return reverse_lazy('books')

class BookList(ListView):
    model=Book
    context_object_name='books'
    
    def get_queryset(self) :
        search_input =self.request.GET.get('search-area') or ''
        
        qs = super().get_queryset().filter(title__icontains=search_input)
        return qs
    

class BookDetail(LoginRequiredMixin,DetailView):
    model=Book
    context_object_name='book'
    
class BookCreate(LoginRequiredMixin,CreateView):
    model=Book
    fields=['title','author','pages']
    success_url=reverse_lazy('books')

    def form_valid(self,form):
        form.instance.user=self.request.user
        return super(BookCreate,self).form_valid(form)

class BookUpdate(LoginRequiredMixin,UpdateView):
    model=Book
    fields=['title','author','pages']
    success_url=reverse_lazy('books')

class BookDelete(LoginRequiredMixin,DeleteView):
    model=Book
    context_object_name='book'
    success_url=reverse_lazy('books')

    
class RegisterPage(FormView):
    template_name='base/register.html'
    form_class=CustomUserCreationForm
    redirect_authenticated_user=True
    success_url=reverse_lazy('books')
    def form_valid(self, form) :
        user=form.save()
        if user is not None:
            login(self.request,user)
        
        return super(RegisterPage,self).form_valid(form)
    def get(self,*args,**kwargs):
        if self.request.user.is_authenticated:
            return redirect('books')
        return super(RegisterPage,self).get(*args,**kwargs)