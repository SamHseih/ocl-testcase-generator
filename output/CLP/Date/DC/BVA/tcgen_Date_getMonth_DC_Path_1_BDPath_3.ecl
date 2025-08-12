:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_getMonth_DC_Path_1_BDPath_3(Self,Result):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],


%CLG Path Constrints,
((((Self_year #>= 1),
(Self_month #>= 1)),
(Self_month #= 12)),
(Self_day #>= 1)),
(Result #= Self_month),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
