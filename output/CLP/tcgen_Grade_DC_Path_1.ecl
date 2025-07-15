:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(random).

tcgen_Grade_DC_Path_1(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],

%CLG Path Constrints,
((Self_number #>= 0),
(Self_number #=< 100)),

%TypeVar Labeling Parts
labeling_int([Self_number]).
