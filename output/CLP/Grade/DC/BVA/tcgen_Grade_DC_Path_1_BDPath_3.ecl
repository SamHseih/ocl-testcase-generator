:- lib(ic).
:- lib(listut).
:- lib(random).
:- lib(timeout).

tcgen_Grade_DC_Path_1_BDPath_3(Self):-

% Class and attribute combined as Class_Attr.
% dim/3 is called if the attribute is an array type.
Self=[Self_number],

%domiain for int Type
[Self_number]#::(-32768)..32767,
%CLG Path Constrints,
((Self_number #> 0) , (Self_number #< 100)),

%TypeVar Labeling Parts
labeling_int([Self_number]).
