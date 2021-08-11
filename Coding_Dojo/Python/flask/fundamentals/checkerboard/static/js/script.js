{% for cell in range(1, row + 1) %}
<li class="row cell flexRow {{ loop.cycle('odd', 'even') }}">{{ cell }}</li>

{% endfor %}