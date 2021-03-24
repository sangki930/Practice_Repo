#프로젝트 이하 관리, project root에 위치한다. 서버가 실행되는 곳이다.
'''
python manage.py runserver 와 같이 manage.py로 서버를 실행~
python manage.py runserver 0:8000 으로 서버를 열면 서버를 연 컴퓨터의 IP:8000로 접속할수 있다.
'''
# 참고 url : https://docs.djangoproject.com/ko/3.1/intro/tutorial01/
#!/usr/bin/env python
"""Django's command-line utility for administrative tasks."""
import os
import sys


def main():
    """Run administrative tasks."""
    os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'config.settings')
    try:
        from django.core.management import execute_from_command_line
    except ImportError as exc:
        raise ImportError(
            "Couldn't import Django. Are you sure it's installed and "
            "available on your PYTHONPATH environment variable? Did you "
            "forget to activate a virtual environment?"
        ) from exc
    execute_from_command_line(sys.argv)


if __name__ == '__main__':
    main()
