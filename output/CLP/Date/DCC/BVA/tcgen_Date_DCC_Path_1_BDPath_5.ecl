:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_DCC_Path_1_BDPath_5(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(Self_year #> 1),
(Self_month #> 1),
(Self_month #< 12),
(Self_day #> 1),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
