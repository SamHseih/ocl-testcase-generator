:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Date_DCC_Path_3_BDPath_4(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_year,Self_month,Self_day],

%CLG Path Constrints,
(Self_year #>= 1),
(Self_month #>= 1),
(Self_month #=< 12),
(Self_day #= 1),
(Self_month #= 8),
(Self_day #=< 31),

%TypeVar Labeling Parts
labeling_int([Self_year, Self_month, Self_day]).
